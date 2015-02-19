package network.week3.protocol;

import java.util.Random;

/**
 * A fairly trivial Medium Access Control scheme.
 * @author Jaco ter Braak, Twente University
 * @version 05-12-2013
 */
public class SlottedAlohaSimplified implements IMACProtocol {

	@Override
	public TransmissionInfo TimeslotAvailable(MediumState previousMediumState,
			int controlInformation, int localQueueLength) {
		System.out.println(previousMediumState);
		System.out.println(controlInformation);
		// No data to send, just be quiet
		if (localQueueLength == 0) {
			return new TransmissionInfo(TransmissionType.Silent, 0);
		}

		// Randomly transmit with 60% probability
		if (new Random().nextInt(100) < 25) {
			return new TransmissionInfo(TransmissionType.Data, 0);
		} else {
			return new TransmissionInfo(TransmissionType.Silent, 0);
		}

	}

}
