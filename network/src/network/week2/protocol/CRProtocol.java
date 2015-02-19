package network.week2.protocol;

import network.week2.client.*;

public class CRProtocol implements IRDTProtocol {

	NetworkLayer networkLayer;

	private Role role = Role.Sender;

	@Override
	public void run() {
		/**
		 * 
		 * Send mode
		 * 
		 */
		if (this.role == Role.Sender) {
			System.out.println("Sending...");

			// set packetSize
			int packetSize = 127;

			// read from the input file
			Integer[] fileContents = Utils.getFileContents();

			// keep track of where we are in the data
			int filePointer = 0;

			// loop until we are done transmitting the file
			boolean stop = false;
			int seqNum = 1;
			while (!stop) {
				Integer[] packetToSend = new Integer[Math.min(packetSize,
						fileContents.length - filePointer) + 1];
				
				for (int i = 0; i < packetSize
						&& filePointer < fileContents.length; i++) {
					packetToSend[i+1] = fileContents[filePointer];
					filePointer++;
				}
				packetToSend[0] = seqNum;
				System.out.println("Sending packet: " + seqNum);
				networkLayer.sendPacket(packetToSend);
				boolean received = false;
				long current = System.currentTimeMillis();
				long timeout = 1000;
				while (!received){
					Integer[] ack = networkLayer.receivePacket();
					if (ack != null && ack[0] == seqNum){
						received = true;
						System.out.println("Received ACK " + seqNum);
					} else if (System.currentTimeMillis() - current > timeout){
						networkLayer.sendPacket(packetToSend);
						current = System.currentTimeMillis();
					}
				}
				seqNum++;
				if (filePointer >= fileContents.length) {
					System.out.println("Reached end-of-file. Done sending.");
					stop = true;
				}
			}

			networkLayer.sendPacket(new Integer[0]);
		}

		/**
		 * 
		 * Receive mode
		 * 
		 */
		else if (this.role == Role.Receiver) {
			System.out.println("Receiving...");
			
			// create the array that will contain the file contents
			Integer[] fileContents = new Integer[0];

			// loop until we are done receiving the file
			boolean stop = false;
			while (!stop) {

				// try to receive a packet from the network layer
				Integer[] packet = networkLayer.receivePacket();

				// if we indeed received a packet
				if (packet != null) {

					// if we reached the end of file, stop receiving
					if (packet.length == 0) {
						System.out.println("Reached end-of-file. Done receiving.");
						stop = true;
					}

					// if we haven't reached the end of file yet
					else {
						// make a new integer array which contains fileContents
						// + packet
						Integer[] newFileContents = new Integer[fileContents.length
								+ packet.length];
						System.arraycopy(fileContents, 0, newFileContents, 0,
								fileContents.length);
						System.arraycopy(packet, 0, newFileContents,
								fileContents.length, packet.length);

						// and assign it as the new fileContents
						fileContents = newFileContents;
					}
				}else{
					// wait ~10ms (or however long the OS makes us wait) before trying again
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						stop = true;
					}
				}
			}

			// write to the output file
			Utils.setFileContents(fileContents);
		}
	}

	@Override
	public void setNetworkLayer(NetworkLayer networkLayer) {
		this.networkLayer = networkLayer;
	}

	@Override
	public void TimeoutElapsed(Object tag) {

	}

	public enum Role {
		Sender, Receiver
	}
}
