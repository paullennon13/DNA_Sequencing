package squencing;

public class Sequencer {
    private final String dnaSequence;
    private final String dnaToMatch;
    private LinkedList<LinkedList<Integer>> matches = new LinkedList<>();

    // Class constructor, takes 2 DNA samples, runs through every combination of chars between them
    Sequencer(String dnaSequence, String dnaToMatch){
        // flips to make bigger DNA sample = dnaSequence
        if(dnaToMatch.length() > dnaSequence.length()){
            this.dnaSequence = dnaToMatch;
            this.dnaToMatch = dnaSequence;
        }
        else {
            this.dnaSequence = dnaSequence;
            this.dnaToMatch = dnaToMatch;
        }
        // iterates through ever combination of chars for dnaSequence and dnaToMatch
        for(int i =0; i < dnaToMatch.length(); i++) {
            for(int j = 0; j < dnaSequence.length(); j++){
                int length = sequence(i,j);
                // if no match go to next set
                if(length == 0){
                    continue;
                }
                // if matches hasn't been initialized
                if(matches.getSize() == 0){
                    LinkedList<Integer> temp = new LinkedList<>(length);
                    temp.addLast(j);
                    matches = new LinkedList<>(temp);
                }
                // sorts matches by length of match and adds start index to list
                for(int k = 0; k < matches.getSize(); k++){
                    int matchLength = matches.get(k).get(0);
                    // if length equals a length list already created add to list
                    if(matchLength == length){
                        matches.get(k).addLast(j);
                        break;
                    }
                    // if length is smaller than matchLength and at the end of list, add length to end of list
                    if(matchLength > length && k == matches.getSize() - 1){
                        LinkedList<Integer> temp = new LinkedList<>(length);
                        temp.addLast(j);
                        matches.addLast(temp);
                        break;
                    }
                    // if length is greater than matchLength add in front of matchLength
                    if(length > matchLength){
                        LinkedList<Integer> temp = new LinkedList<>(length);
                        temp.addLast(j);
                        if (k == 0) {
                            matches.addFirst(temp);
                        }
                        else {
                            matches.add(temp, k - 1);
                        }
                        break;
                    }
                }
            }
        }
    }

    // Given a starting index for each DNA sample, counts character matches from start indexes
    private int sequence(int index, int index1){
        int count = 0;
        try {
            char a = dnaSequence.charAt(index1);
            char b = dnaToMatch.charAt(index);
            // if chars match add one to count and call self with indexes + 1
            if (a == b) {
                count++;
                // once match not found will return the number of recursive calls a.k.a. number of matching chars
                count += sequence(index + 1, index1 + 1);
            }
        } catch (StringIndexOutOfBoundsException e){
            return count;
        }
        return count;
    }

    // Outputs the top 10 matches of the two provided DNA samples
    public String toString(){
        StringBuilder string = new StringBuilder();
        int j = 2;
        int k = 1;
        if (matches.isEmpty()) {
            return "No Matches found!";
        }
        // for loop to get top ten matches
        for(int i = 1; i <= 10; i++) {
            string.append("Match number ")
                    .append(i)
                    .append(": ");
            if (j > matches.get(k).getSize()) {
                k++;
                j = 2;
            }
            int length = matches.get(k).get(0);
            int startIndex = matches.get(k).get(j);
            // if length of match equals one just adds char at start index
            if(length == 1){
                string.append(dnaSequence.charAt(startIndex));
            }
            // if length greater than 1 take substring of dnaSequence starting at start index and ending at
            // start index + length, NOTE: lowest possible value is 1, 0 length matches not added to list
            else {
                string.append(dnaSequence, startIndex, startIndex + length);
            }
            j++;
            // adds new line char to every line
            string.append("\n");
        }
        return string.toString();
    }
}
