class Solution {
    public List<String> addOperators(String num, int target) {
        ArrayList<String> result = new ArrayList<>();
        generate(result,num,target,0,0,0,"");
        return result;
    }

    static void generate(ArrayList<String> result, String num,
            int target, long current, long prevOperand, int index, String currentPattern) {
        if (index == num.length() && current == target) {
            result.add(currentPattern);
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i > index && num.charAt(index) == '0')
                break;
            long currentNum = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                generate(result, num, target, currentNum, currentNum, i + 1, "" + currentNum);
            } else {

                generate(result, num, target, current + currentNum, currentNum, i + 1,
                        currentPattern + "+" + currentNum);

                generate(result, num, target, current - currentNum, -currentNum, i + 1,
                        currentPattern + "-" + currentNum);

                generate(result, num, target, current - prevOperand + prevOperand * currentNum,
                        prevOperand * currentNum, i + 1, currentPattern + "*" + currentNum);

            }
        }
    }
}