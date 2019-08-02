ChromeDriver for macOS requires Chrome version 76.0.3809.68
ChromeDriver path is defined on driverPath string

Test Case 1 "ShortTermTest":
Set up the driver and open Park Calc webpage
Uses DataProvider to fill Entry Time and Date ("2:00 AM", "11/11/2019")
Uses DataProvider to fill Leaving Time and Date ("4:00 AM", "11/11/2019")
Clicks on Calculate button
Perform assertion on COST (value in $)


Test Case 2 "ShortTermTestDDHHMM":
Set up the driver and open Park Calc webpage
Uses DataProvider to fill Entry Time and Date ("12:00 AM", "11/11/2019")
Uses DataProvider to fill Leaving Time and Date ("4:30 AM", "11/11/2019")
Clicks on Calculate button
Perform assertion on Days, Hours and Minutes


Test Case 3 "LongTermTestDDHHMM":
Set up the driver and open Park Calc webpage
Uses DataProvider to fill Entry Time and Date ("12:00 AM", "11/11/2019")
Uses DataProvider to fill Leaving Time and Date ("12:00 AM", "11/11/2020")
Clicks on Calculate button
Perform assertion on Days, Hours and Minutes