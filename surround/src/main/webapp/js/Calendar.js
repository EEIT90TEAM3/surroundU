var current = 
{
	'year':  new Date().getFullYear(),
	'month': new Date().getMonth() + 1,
	'date':  new Date().getDate()
};

var choose = 
{
	'year':  current.year,
	'month': current.month,
	'date':  current.date,
	'hour':  0,
	'minute':0
};

$(function()
{
	drawCalendar(current);
	$('#calendar tbody').on({click: function()
	{		
		$('#calendar tbody td.selected').removeClass('selected');
		
		choose.date = parseFloat($(this).text());
		$(this).addClass('selected');
		showList();
	}}, "td");
	
	$('#lastMonth').click(function(){changeMonth(-1)});
	$('#year').click(     function(){changeMonth(0)});	//back to current year
	$('#nextMonth').click(function(){changeMonth(1)});
	
	$('#hourText').change( function() {setTimeRange (this, $(this).val());});
	$('#hourRange').change(function() {setTimeNumber(this, $(this).val());});
	
	$('#minuteText').change( function() {setTimeRange (this, $(this).val());});
	$('#minuteRange').change(function() {setTimeNumber(this, $(this).val());});
});

function changeMonth(changeRange)
{
	choose.month = (changeRange == 0) ? current.month : (choose.month += changeRange);
	
	var lastOrNextYear = (choose.month > 12) - (choose.month < 1);	//Jump to Last Year(= -1) or Next Year(= 1) or not(= 0)
	choose.year += lastOrNextYear;
	choose.month -= 12 * lastOrNextYear;	//Last Year(0 + 12), Next Year(13 - 12)
	
	var currentYearAndMonth = (choose.year == current.year && choose.month == current.month)
	choose.date = currentYearAndMonth ? current.date : 1;
	
	drawCalendar(choose);
}

function drawCalendar(dateJSON)
{
	$('#year').html(dateJSON.year + "年 " + dateJSON.month + "月");
	var dateEnd = new Date(dateJSON.year, dateJSON.month, 0).getDate();	//Get the end of the choosed month(28, 29, 30 or 31)
	var dayStart = new Date(dateJSON.year, (dateJSON.month - 1), 1).getDay(); //Get choosed month's first day
	
	var dateList = "<tr>";
	if(dayStart > 0)
		dateList += "<td id=\"ignoreData\" colspan=" + dayStart + "></td>";
	
	var dateCount = 1;
	var SaturdayDate = 7 - dayStart;
	while(dateCount <= dateEnd)
	{
		dateList += "<td>" + (dateCount++) + "</td>";
		if(dateCount > SaturdayDate)	//new week
		{					        //Final week
			SaturdayDate = ((dateCount + 6) > dateEnd) ? dateEnd : (dateCount + 6);
			dateList += "</tr><tr>";
		}
	}
	
	dateList += "</tr>";
	$('#calendar tbody').html(dateList)
						.find('td')
						.filter(function() {return (parseFloat($(this).text()) == dateJSON.date);})
						.addClass('selected');
	showList();
}

function setTimeNumber(id, value) 
{
	$(id).prev().val(value);
	setChoosedTime();
	showList();
}

function setTimeRange(id, value)
{
	var NotANumber = isNaN(parseFloat(value));
	var higherThanMaxValue = (value > parseFloat($(id).attr("max")));
	var lowerThanMinValue =  (value < parseFloat($(id).attr("min")));
	if(NotANumber || higherThanMaxValue || lowerThanMinValue)
	{
		$(id).val($(id).next().val());
		return;
	}
	
	$(id).next().val(value);
	setChoosedTime();
	showList();
}

function setChoosedTime()
{
	choose.hour = $('#hourRange').val();
	choose.minute = $('#minuteRange').val();
}

function showList()
	{$('#calendar caption').html($('#year').text() + choose.date + "日 " + prependZero(choose.hour) + ":" + prependZero(choose.minute));}

function prependZero(vari) {return (vari < 10) ? ("0" + vari) : vari;}