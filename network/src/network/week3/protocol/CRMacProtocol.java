package network.week3.protocol;

import java.util.*;

public class CRMacProtocol implements IMACProtocol {
	private int timer;
	private int collisions;

	public TransmissionInfo TimeslotAvailable(MediumState previousMediumState,
			int controlInformation, int localQueueLength) {
		if (localQueueLength == 0) {
			return new TransmissionInfo(TransmissionType.Silent, 0);
		}
		if(previousMediumState != MediumState.Collision && timer <= 0){
			collisions = 0;
			timer = 0;
			return new TransmissionInfo(TransmissionType.Data, 0);
		} else {
			collisions++;
			if (timer <= 0) {
				timer = getRandomTime(collisions);
			} else {
				timer--;
			}
			return new TransmissionInfo(TransmissionType.Silent, 0);
		}
	}

	public int getRandomTime(int collisions) {
		Set<Integer> times = new HashSet<Integer>();
		for (int i = 0; i < (int) Math.pow(2, collisions)-1; i++) {
			times.add(i);
		}
		while (true) {
			int randomNum = (int) (Math.random() * times.size());
			if (times.contains(randomNum)) {
				return randomNum;
			}
		}
	}
}
