public static boolean cr(String strAmount) {
        boolean isDollarOrEuro = false;
        boolean isParenthessExist = false;
        boolean isNegative = false;

        if (strAmount.equals("")){
            return false;
        }

        if (strAmount.charAt(0) != '\u0024' && strAmount.charAt(0) != '\u20AC' && strAmount.charAt(0) != '\u00A5' && strAmount.charAt(0) != '(' && strAmount.charAt(0) != '-'){
            return false;
        }

        if (strAmount.charAt(0) == '(' || strAmount.charAt(0) == '-'){
            isNegative = true;
            if (strAmount.charAt(0) == '('){
                isParenthessExist = true;
            }
            strAmount = strAmount.substring(1);
        }

        if (strAmount.equals("")){
            return false;
        }

        if (isNegative && strAmount.charAt(0) != '\u0024' && strAmount.charAt(0) != '\u20AC' && strAmount.charAt(0) != '\u00A5'){
            return false;
        }

        if (strAmount.charAt(0) == '\u0024' || strAmount.charAt(0) == '\u20AC'){
            isDollarOrEuro = true;
        }

        strAmount = strAmount.substring(1);

        if (strAmount.equals("")){
            return false;
        }

        if (strAmount.indexOf('.') != -1 && !isDollarOrEuro){
            return false;
        }

        if (strAmount.equals("0")){
            return true;
        }

        if (isDollarOrEuro && strAmount.indexOf('.') != -1){
            if (strAmount.charAt(0) == '0' && strAmount.indexOf('.') != 1){
                return false;
            }
        }

        if (strAmount.indexOf('.') != -1){
            if (strAmount.indexOf('.') != (strAmount.length() - 3)){
                return false;
            }
        }

        if (strAmount.indexOf('.') == strAmount.length() - 1){
            return false;
        }

        if (isParenthessExist){
            if (strAmount.charAt(strAmount.length() - 1) != ')'){
                return false;
            }
            strAmount = strAmount.substring(0, strAmount.length() -1);
        }

        HashSet<Integer> set = new HashSet<>();

        if (strAmount.indexOf(',') != -1){
            String tmp = (strAmount.indexOf('.') == - 1) ? strAmount : strAmount.substring(0, strAmount.indexOf('.'));

            for (int i = tmp.length() - 4; i>=0; i-=3){
                if (tmp.charAt(i) != ','){
                    return false;
                }
                else{
                    if (i == 0){
                        return false;
                    }

                    set.add(i);
                    i--;
                }
            }
        }

        int dotCount = 0;
        int pCount = 0;

        for (int i = 0; i < strAmount.length(); i++){
            if (strAmount.charAt(i) == '.'){
                dotCount++;
            }

            if (dotCount > 1){
                return false;
            }

            if (strAmount.charAt(i) == ',' && !set.contains(i)){
                return false;
            }

            if (!Character.isDigit(strAmount.charAt(i)) && strAmount.charAt(i) != '.' && strAmount.charAt(i) != ','){
                return false;
            }
        }

        return true;
    }
