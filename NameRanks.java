package vjezbe;

import java.util.ArrayList;

public class NameRanks {
	private int rank = 0;
	private String mName = "";
	private int mNumbers = 0;
	private String fName = "";
	private int fNumbers = 0;
	
		public NameRanks(){
		}
		
		public NameRanks(int rank, String mName, int mNumbers, String fName, int fNumbers){
			this.setRank(rank);
			this.setmName(mName);
			this.setmNumbers(mNumbers);
			this.setfName(fName);
			this.setfNumbers(fNumbers);
		}

		/**
		 * @return the rank
		 */
		public int getRank() {
			return rank;
		}

		/**
		 * @param rank the rank to set
		 */
		public void setRank(int rank) {
			this.rank = rank;
		}

		/**
		 * @return the mName
		 */
		public String getmName() {
			return mName;
		}

		/**
		 * @param mName the mName to set
		 */
		public void setmName(String mName) {
			this.mName = mName;
		}

		/**
		 * @return the mNumbers
		 */
		public int getmNumbers() {
			return mNumbers;
		}

		/**
		 * @param mNumbers the mNumbers to set
		 */
		public void setmNumbers(int mNumbers) {
			this.mNumbers = mNumbers;
		}

		/**
		 * @return the fName
		 */
		public String getfName() {
			return fName;
		}

		/**
		 * @param fName the fName to set
		 */
		public void setfName(String fName) {
			this.fName = fName;
		}

		/**
		 * @return the fNumbers
		 */
		public int getfNumbers() {
			return fNumbers;
		}

		/**
		 * @param fNumbers the fNumbers to set
		 */
		public void setfNumbers(int fNumbers) {
			this.fNumbers = fNumbers;
		}
		
		@Override
		public String toString(){
			return rank + " " + mName + " " + mNumbers + " " + fName + " " + fNumbers;
		}
	}


