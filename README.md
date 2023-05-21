<h3 style="text-align: center;">Pair of employees who have worked together</h3>

<h4 style="text-align: center;"> Application that identifies the pair of employees who have worked together on common projects for the longest period of time.</h4>

* Supports .csv files in format: employee ID, project ID, start date, end date.
* Calculations are end date inclusive.
* Dates can be in the following formats:
    * YYYY-MM-dd or YY-MM-dd
    * YYYY-MMM-dd or YY-MMM-dd (US locale only)
    * YYYY-MMMM-dd or YY-MMMM-dd  (US locale only)
    * date separator can be space ( ), dot (.), dash (-) or slash (/)
      <br/><br/>
* File validation with line indicator for the following:
    * date is in the wrong format
    * partial employee info
      <br/><br/>
* Unit tests.
* Sample csv files in "test" directory.
* User-friendly GUI.