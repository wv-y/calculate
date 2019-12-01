package com.example.calculate;


class scienceCal {

    private BaseCalculator baseCalculator = new BaseCalculator();

    double cal(String math) {

        //(1)预处理math

        math = math.replace("π", String.valueOf(Math.PI));          //替换π
        math = math.replace("e", String.valueOf(Math.exp(1)));      //替换自然指数e

        //(2)计算指数(pow)运算并替换，包括(x)^(y)
        while (math.contains("^")) {

            //1.中间寻找的点，即^的位置
            int midIndex = math.lastIndexOf("^");

            //2.获取左边参数
            double leftNum; //左边的数
            String leftStr; //左边math字符串
            int leftIndex = midIndex - 1;

            if (math.charAt(leftIndex) == ')') {        //1.幂运算符的左边是一个表达式，即左边用括号括起来
                int i = leftIndex - 1;
                while (math.charAt(i) != '(') {        //查找左括弧，得到括弧之间的表达式
                    i--;
                }
                String subLeftMath = math.substring(i + 1, leftIndex); //截取得到括弧之间的表达式
                leftNum = baseCalculator.cal(subLeftMath);


                leftStr = "(" + subLeftMath + ")";
            } else {                                    //2.左边是一个数

                //注意：判定index范围一定要在左边，否则可能出现IndexOutOfRange异常
                while (leftIndex >= 0 && !isOper(math.charAt(leftIndex))) {
                    leftIndex--;
                }
                leftStr = math.substring(leftIndex + 1, midIndex);
                leftNum = Double.parseDouble(leftStr);
            }

            //3.获取右边参数，与上面操作类似
            double rightNum;
            String rightStr;
            int rightIndex = midIndex + 1;

            if (math.charAt(rightIndex) == '(') {
                int i = rightIndex + 1;
                while (math.charAt(i) != ')') {
                    i++;
                }
                String subRightMath = math.substring(rightIndex + 1, i);
                rightNum = baseCalculator.cal(subRightMath);
                rightStr = "(" + subRightMath + ")";
            } else {
                while (rightIndex < math.length() && !isOper(math.charAt(rightIndex))) {
                    rightIndex++;
                }
                rightStr = math.substring(midIndex + 1, rightIndex);
                rightNum = Double.parseDouble(rightStr);
            }

            //4.得到完整的运算式并运算，并用计算结果替换^的表达式
            String wholeMath = leftStr + "^" + rightStr;
            double result = Math.pow(leftNum, rightNum);
            math = math.replace(wholeMath, String.valueOf(result));
        }

        //(3)计算其他的科学运算符
        while (math.contains("sin") || math.contains("cos") || math.contains("tan") || math.contains("ln") || math.contains("√")) {

            //1.获取()内运算式并计算出结果，此时假设()不再包含复杂的科学运算
            int beginIndex = math.lastIndexOf("(");
            int endIndex = getRightBracket(math, beginIndex);
            String subMath = math.substring(beginIndex + 1, endIndex);
            double subResult = baseCalculator.cal(subMath);


            //2.获取scienceOper字符串
            int i = beginIndex - 1;
            while (i >= 0 && !isOper(math.charAt(i))) { //向左寻找
                i--;
            }
            String scienceOper = math.substring(i + 1, beginIndex);

            //3.匹配scienceOper进行科学运算，并替换相应部分
            String tempMath;
            double tempResult;
            switch (scienceOper) {
                case "sin":
                    tempMath = "sin(" + subMath + ")";//函数的表达式部分

                    tempResult = Math.sin(subResult / 180 * Math.PI); //将弧度转化为角度

                    math = math.replace(tempMath, String.valueOf(tempResult)); //将函数表达式部分用计算结果替换
                    break;
                case "cos":
                    tempMath = "cos(" + subMath + ")";

                    tempResult = Math.cos(subResult / 180 * Math.PI);

                    math = math.replace(tempMath, String.valueOf(tempResult));
                    break;
                case "tan":
                    tempMath = "tan(" + subMath + ")";
                    tempResult = Math.tan(subResult / 180 * Math.PI);
                    math = math.replace(tempMath, String.valueOf(tempResult));
                    break;
                case "ln":
                    tempMath = "ln(" + subMath + ")";
                    tempResult = Math.log(subResult);
                    math = math.replace(tempMath, String.valueOf(tempResult));
                    break;
                case "√":
                    tempMath = "√(" + subMath + ")";
                    tempResult = Math.sqrt(subResult);
                    math = math.replace(tempMath, String.valueOf(tempResult));
                    break;
                default:
                    break;
            }
        }
        //(4)此时的math已经替换到BaseCalculator可处理的形式

        double b = baseCalculator.cal(math);
        return Double.parseDouble(String.format("%.3f", b)); //四舍五入保留三位小数
    }

    private int getRightBracket(String math, int begin) {
        int i;
        for (i = begin; i < math.length(); i++) {
            if (math.charAt(i) == ')')
                break;
        }
        return i;
    }


    //判断字符是否为运算符
    private boolean isOper(char c) {
        char[] operSet = {'+', '-', '*', '/', '('};
        int i;
        for (i = 0; i < operSet.length; i++) {
            if (c == operSet[i]) {
                return true;
            }
        }
        return false;
    }


}
