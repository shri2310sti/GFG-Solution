class Solution {
static int countBit(int num) {
int count = 0;
while (num>0) {
num &= (num - 1);
count++;
}
return count;
}
public String profession(int level, int pos) {
// code here
 
boolean val = (countBit(pos - 1)&1) == 0;
 
return val?"Engineer":"Doctor";
 
}
}