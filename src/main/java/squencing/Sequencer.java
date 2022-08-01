package squencing;

public class Sequencer {
    private String dnaSequence;
    private String dnaToMatch;
    private LinkedList<LinkedList<Integer>> matches = new LinkedList<>();

    Sequencer(String dnaSequence, String dnaToMatch){
        if(dnaToMatch.length() > dnaSequence.length()){
            this.dnaSequence = dnaToMatch;
            this.dnaToMatch = dnaSequence;
        }
        else {
            this.dnaSequence = dnaSequence;
            this.dnaToMatch = dnaToMatch;
        }
        for(int i =0; i < dnaToMatch.length(); i++) {
            for(int j = 0; j < dnaSequence.length(); j++){
                int length = sequence(i,j);
                if(length == 0){
                    continue;
                }
                if(matches.getSize() == 0){
                    LinkedList<Integer> temp = new LinkedList<>(length);
                    temp.addLast(j);
                    matches = new LinkedList<>(temp);
                }
                for(int k = 0; k < matches.getSize(); k++){
                    int matchLength = matches.get(k).get(0);
                    if(matchLength == length){
                        matches.get(k).addLast(j);
                        break;
                    }
                    if(matchLength > length && k == matches.getSize() - 1){
                        LinkedList<Integer> temp = new LinkedList<>(length);
                        temp.addLast(j);
                        matches.addLast(temp);
                        break;
                    }
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

    private int sequence(int index, int index1){
        int count = 0;
        try {
            char a = dnaSequence.charAt(index1);
            char b = dnaToMatch.charAt(index);
            if (a == b) {
                count++;
                count += sequence(index + 1, index1 + 1);
            }
        } catch (StringIndexOutOfBoundsException e){
            return count;
        }
        return count;
    }

    public LinkedList<LinkedList<Integer>> getMatches() {
        return matches;
    }

    public String getDnaSequence() {
        return dnaSequence;
    }

    public String getDnaToMatch() {
        return dnaToMatch;
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        int j = 2;
        int k = 1;
        if (matches.isEmpty()) {
            return "No Matches found!";
        }
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
                if(length == 1){
                    string.append(dnaSequence.charAt(startIndex));
                }
                else {
                    string.append(dnaSequence, startIndex, startIndex + length);
                }
                j++;
            string.append("\n");
        }
        return string.toString();
    }
}
