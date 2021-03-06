"""
Created on 2019/2/2 10:12

@author: coderwangson
"""
"#codeing=utf-8"


class Solution:
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        dict_char = {1:'I',5:'V',10:'X',50:'L',100:'C',500:'D',1000:'M'}
        special_num = [4,9,40,90,400,900]
        special_num_char ={4:'IV',9:'IX',
                           40:'XL',90:'XC',
                           400:'CD',900:'CM'}
        if num == 0:
            return ''
        if str(num)[0]=='4':
            base = 400
            #看是400多还是40多（因为题目中要求不超过3999）
            while num -base<0:
                base=base//10
            #把剩下的部分进行递归
            return special_num_char[base] + Solution().intToRoman(num - base)
        if str(num)[0]=='9':
            base = 900
            while num - base < 0:
                base = base // 10
            return special_num_char[base] + Solution().intToRoman(num - base)

        keys = sorted(list(dict_char.keys()),reverse=True)
        # 看是多个1000还是多个500等等
        for base in keys:
            if num//base>0:
                i = num//base
                # 把余数进行递归
                return dict_char[base]*i+Solution().intToRoman(num%base)
print(Solution().intToRoman(1994))