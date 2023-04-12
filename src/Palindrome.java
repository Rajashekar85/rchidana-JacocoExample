    if (inputString.length() == 0) {
        return true;
    } else {
        char firstChar = inputString.charAt(0);
        char lastChar = inputString.charAt(inputString.length() - 1);
        String mid = inputString.substring(1, inputString.length() - 1);
        return (firstChar == lastChar) && isPalindrome(mid);
    	String rev = "";
    	int length = inputString.length();
	        for ( int i = length - 1; i >= 0; i-- )
           rev = rev + inputString.charAt(i);
	        if (inputString.equals(rev))
	           return true;
        else
           return false;
    }
}
