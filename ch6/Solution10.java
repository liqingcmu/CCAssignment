package cc.chapter6;

import java.util.ArrayList;

public class Solution10 {
	/**
	 * Method 1: 
	 * Assume that there'll be multiple test stripes at each round.
	 * Divide the bottles across the 10 test stripes, first in group of 100.
	 * Wait 7 days and there'll be a poisoned test strip.
	 * Select the bottles associated with the poisoned test strip, and repeat the process.
	 * Perform until there's only one bottle left in the test set.
	 * It will take  21 days.*/
	
	/**Method 2:
	 * We can configure binary expression for 1000 bottles. 2^10 = 1024 > 1000.
	 * This method costs 7 days. If test strip i is positive, then set bit i of the result value.
	 * Integrating all the bits of the test strips and we will get the ID of the poisoned bottle. */
	
	
	public class TestStrip{
		public static final int DAYS_RESULT = 7;
		private ArrayList<ArrayList<Bottle>> dropsByDay = new ArrayList<ArrayList<Bottle>>();
		private int id;
		public TestStrip(int id){
			this.id = id;
		}
		public int getId(){
			return id;
		}
		//Method 1
		public int findPoisonedBottle (ArrayList<Bottle> bottles, ArrayList<TestStrip> strips){
			int today = 0;
			while (bottles.size() > 1 && strips.size() > 1){
				runTestSet(bottles, strips, today);
				today = today + DAYS_RESULT;
				for (TestStrip strip : strips){
					if (strip.isPoisonedOnDay(today)){
						bottles = strip.lastWeekResults(today);
						strips.remove(strip);
						break;
					}
				}
			}
			if (bottles.size() == 1)
				return bottles.get(0).getId();
			return -1;
		}
		public void runTestSet (ArrayList<Bottle> bottles, ArrayList<TestStrip> strips, int day){
			int i = 0;
			for (Bottle b : bottles){
				TestStrip strip = strips.get(i);
				strip.addDropOnDay(day, b);
				i = (i + 1) % strips.size();
			}
		}
		//Method 2:
		public int findPoisonedBottle2 (ArrayList<Bottle> bottles, ArrayList<TestStrip> strips){
			runTestSet2(bottles, strips);
			ArrayList<Integer> results = getPositiveOnDay(strips, 7);
			return setBit(results);
		}
		//Drop bottles' contents to strips
		public void runTestSet2 (ArrayList<Bottle> bottles, ArrayList<TestStrip> strips){
			for (Bottle b : bottles){
				int id = b.getId();
				int bitIndex = 0;
				while (id > 0){
					if ((id & 1) == 1)
						strips.get(bitIndex).addDropOnDay(0, b);
				}
				bitIndex++;
				id >>= 1;
			}
		}
		// Get positive test strips on a specific day.
		public ArrayList<Integer> getPositiveOnDay(ArrayList<TestStrip> strips, int day){
			ArrayList<Integer> results = new ArrayList<Integer>();
			for (TestStrip s : strips){
				if (s.isPoisonedOnDay(day))
					results.add(s.getId());
			}
			return results;
		}
		//Create the binary bit corresponding to specific test strips
		public int setBit(ArrayList<Integer> results){
			int id = 0;
			for (Integer bitIndex : results){
				id = id | (1 << bitIndex);
			}
			return id;
		}
		// Infrastructure 
		//Resize list of days/drops to be large enough.
		public void size (int day){
			while (dropsByDay.size() < day)
				dropsByDay.add(new ArrayList<Bottle>());
		}
		//Add drop from bottle on specific day.
		public void addDropOnDay (int day, Bottle bottle){
			size(day);
			ArrayList<Bottle> drops = dropsByDay.get(day);
			drops.add(bottle);
		}
		//Check if any one of arrayList of bottle is poisoned.
		public boolean hasPoinson (ArrayList<Bottle> bottles){
			for (Bottle b : bottles){
				if (b.isPoisoned())
					return true;
			}
			return false;
		}
		//Get bottles used in the test DAYS_RESULT days ago.
		public ArrayList<Bottle> lastWeekResults (int day){
			if (day < DAYS_RESULT)
				return null;
			return dropsByDay.get(day-DAYS_RESULT);
		}
		//Check if the bottles are poisoned since DAYS_RESULT. 
		public boolean isPoisonedOnDay (int day){
			int testDate = day - DAYS_RESULT;
			if (testDate < 0 || testDate >= dropsByDay.size())
				return false;
			for (int d = 0; d < day; d++){
				ArrayList<Bottle> bottles = dropsByDay.get(d);
				if (hasPoinson(bottles))
					return true;
			}
			return false;
		}
	}
	public class Bottle{
		private int id;
		private boolean poisoned = false;
		public Bottle (int id){
			this.id = id;
		}
		public int getId() {
			return id;
		}
		public boolean isPoisoned() {
			return poisoned;
		}
		public void setPoisoned() {
			this.poisoned = true;
		}
	}
}
