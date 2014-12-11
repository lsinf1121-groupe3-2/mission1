5 2 exch div pstack 0.7 add pstack ne pstack pop
/pi 3.141592653 def 
5 1 sub pstack pop 
-1 -1 div pstack 1 5 dup -3 exch add pstack add pstack 6 exch pop pop sub pstack pop
3 5 exch sub 1 div pstack dup sub pi div pstack pop 
pi dup mul div sub pstack

5 2 add pstack pop : 7
7 3 sub pstack pop : -4
4 6 mul pstack pop : 24
1 8 div pstack pop : 8
0 4 div pstack pop : division by zero
14 0 exch pstack pop pop : 0 14
4 4 eq 7 -3 ne pstack pop pop : true true
4 4 ne 7 -3 eq pstack pop pop : false false
27 dup pstack pop pstack pop : 27 27 (à la ligne) 27
/Florent 190195 def 
Florent pstack : 190195

7 3 add pstack 50 div /B 85 def B sub 4 pstack exch dup pstack pop pstack mul 320 eq 14 22 ne pstack pop pop pstack

dupl 12 sub 4 add 3 div add add 3 div 0 0 4 3 2 pop pop pstack
exch pop mult mult 1 2 3 4 5 ne eq pop pop 7 8 9

7+3 = 10 | 50/10 = 5 | 85-5=80 | 80 4 | 4 80 | 4 80 80 | 4 80 | 320 | 320 320 | true | | 14 22 | true

