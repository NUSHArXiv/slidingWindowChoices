# Mass Testing

import datetime as dt
from random import randint, shuffle, choice

today = dt.datetime.now()

def randomSample():
    expiry = (today + dt.timedelta(randint(-180,360))).strftime("%d-%b-%Y")
    tripType = choice(["B", "S", "V", "N"])
    trip = (today + dt.timedelta(randint(0,360))).strftime("%d-%b-%Y") if tripType != "N" else "NIL"
    return (i, "", "", expiry, trip, tripType)


file = open("tests/applicants3.csv", "w+")
print("10000,14-Aug-2022", file=file)
for i in range(10000):
    print(*randomSample(), sep=",", file=file)


file.close()
