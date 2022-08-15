# Test 1

import datetime as dt
from random import randint

today = dt.datetime.now().date()

expiryDate1 = today + dt.timedelta(100)
tripDate1 = today + dt.timedelta(120)
tripPurpose1 = "B"

expiryDate2 = today + dt.timedelta(200)
tripDate2 = today + dt.timedelta(120)
tripPurpose2 = "B"

expiryDate3 = today + dt.timedelta(200)
tripDate3 = today + dt.timedelta(120)
tripPurpose3 = "S"

expiryDate4 = today + dt.timedelta(200)
tripDate4 = today + dt.timedelta(240)
tripPurpose4 = "S"


print(expiryDate1.strftime("%d-%b-%Y"), tripDate1.strftime("%d-%b-%Y"), tripPurpose1, sep=",")
print(expiryDate2.strftime("%d-%b-%Y"), tripDate2.strftime("%d-%b-%Y"), tripPurpose2, sep=",")
print(expiryDate3.strftime("%d-%b-%Y"), tripDate3.strftime("%d-%b-%Y"), tripPurpose3, sep=",")
print(expiryDate4.strftime("%d-%b-%Y"), tripDate4.strftime("%d-%b-%Y"), tripPurpose4, sep=",")
