class StringIterator {

    char [] Ar;
    int index = 0;
    
    public StringIterator(String compressedString) {
        Ar = compressedString.toCharArray();
    }
    
    public char next() {
        if(hasNext()){
            return Ar[index++];
        } else {
            return ;
        }
    }
    
    public boolean hasNext() {
        if(index<Ar.length){
            return true;
        } else {
            return false;
        }
    }
}