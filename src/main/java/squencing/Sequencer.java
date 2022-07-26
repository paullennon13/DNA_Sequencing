package squencing;

public class Sequencer {
    private String dnaSequence;
    private String dnaToMatch;
    private LinkedList<LinkedList<Integer>> matches;

    Sequencer(){
        this(null, null);
    }

    Sequencer(String dnaSequence, String dnaToMatch){
        if(dnaToMatch.length() > dnaSequence.length()){
            this.dnaSequence = dnaToMatch;
            this.dnaToMatch = dnaSequence;
        }
        else {
            this.dnaSequence = dnaSequence;
            this.dnaToMatch = dnaToMatch;
        }
        for(int i =0; i < dnaSequence.length(); i++) {
            LinkedList<Integer> temp = new LinkedList<>(sequence(i,0));
            temp.addLast(i);
            for(int j = 0; j < matches.getSize(); j++){
                if(temp.get(0).compareTo(matches.get(j).get(0)) < 0){
                    matches.add(temp, j);
                }
                else if(temp.get(0).compareTo(matches.get(j).get(0)) == 0){
                    matches.get(j).addLast(i);
                }
            }
        }
    }

    public int sequence(int index, int index1){
        int count = 0;

            char a = dnaSequence.charAt(index1);
            char b = dnaToMatch.charAt(index);
            if(a == b){
                count++;
                count += sequence(index + 1, index1 + 1);
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
        int j = 0;
        int k = 1;
        for(int i = 0; i < 10; i++){
            if(k > matches.get(j).getSize()){
                k = 1;
                j++;
            }
            int length = matches.get(j).get(0);
            int startIndex = matches.get(j).get(k);
            string.append(dnaSequence.substring(startIndex, (startIndex + length ) - 1));
            k++;
        }


        return string.toString();
    }
}
