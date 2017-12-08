package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author basila
 * 
 * https://leetcode.com/problems/flatten-nested-list-iterator/discuss/
 *
 */

//recursive solution
public class FlattenNestedList {
	
	public class NestedIterator implements Iterator<Integer> {
		private int index = 0;
		private List<Integer> list = new ArrayList<>();
		
		public NestedIterator(List<NestedInteger> nestedList) {
			FlattenNestedList(nestedList);
		}
		
		private void flatten(List<NestedInteger> nestedList) {
			for(NestedInteger nestedInteger : nestedList) {
				if (nestedInteger.isInteger()) {
					list.add(nestedInteger.getInteger());
				} else {
					flatten(nestedInteger.getList());
				}
			}
		}
		@Override
		public Integer next() {
			return list.get(index++);
		}
		@Override
		public boolean hasNext() {
			return index < list.size();
		}
	}

}
