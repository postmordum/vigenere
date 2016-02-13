


def shiftForward(shift,letter):
    shift_num = ord(shift)
    letter_num = ord(letter)
    shifted_num = letter_num
    if letter_num>31 and letter_num<127:
        shifted_num = (letter_num + shift_num)
        while shifted_num > 126:
            gap = shifted_num - 126
            shifted_num = gap + 31
    return chr(shifted_num)
    
def shiftBackward(shift,letter):
    shift_num = ord(shift)  
    letter_num = ord(letter)
    shifted_num = letter_num
    if letter_num>31 and letter_num<127:
        shifted_num = (letter_num - shift_num)
        while shifted_num < 32:
            gap = 32 - shifted_num
            shifted_num = 127 - gap
    return chr(shifted_num)
    
def vigenere(key,text,decrypt=None):
    if decrypt == None:
        decrypt = False
    output = "";
    key_len = len(key)
    for i,t in enumerate(text):
        kp = i%key_len;
        c = key[kp];
        if decrypt :
            o = shiftBackward(c,t)
        else:
            o = shiftForward(c,t)
        output += o;
    return output;

def test0():
    password = "abcd"
    text = "abcdefghijklmnopqrstuvwxyz"
    e = vigenere(password,text,False)
    d = vigenere(password,e,True)
    print("password:"+password)
    print("text:"+text)
    print("encrypted:"+e)
    success = (d==text)
    print("--PASS--" if success else "--FAIL--"+d)
    return success
def test1():
    password = "1243"
    text = "1234567890\nABCDEFGHIJKLMNOPQRSTUVWXYZ\n"
    e = vigenere(password,text,False)
    d = vigenere(password,e,True)
    print("password:"+password)
    print("text:"+text)
    print("encrypted:"+e)
    success = (d==text)
    print("--PASS--" if success else "--FAIL--"+d)
    return success
    
test0()
test1()
    
    
    
    
