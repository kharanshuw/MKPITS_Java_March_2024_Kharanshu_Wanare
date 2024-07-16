function dateDiff(date1, date2) {
    let yearDiff = date2.getFullYear() - date1.getFullYear();
    let monthDiff = date2.getMonth() - date1.getMonth();
  
    // Handle negative month difference (borrow from year)
    if (monthDiff < 0) {
      yearDiff--;
      monthDiff += 12;
    }
  
    // Calculate difference in days considering leap years (more complex)
    // Omit this part for simpler day difference calculation
    // ...
  
    return {
      years: yearDiff,
      months: monthDiff,
    }; // You can add days, hours, minutes, etc. based on your needs
  }
  
  const date1 = new Date("1999-10-18");
  const date2 = new Date();
  
  const difference = dateDiff(date1, date2);
  console.log("Difference:", difference); // Output: { years: 0, months: 6 }
  