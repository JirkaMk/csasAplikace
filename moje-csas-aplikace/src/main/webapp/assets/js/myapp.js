$(function() {
	/* solving the active menu problem - pridava do menu listu z navbar.jsp
    tridu active */
	switch(menu) {
	
		case 'About Us': // porovnava se hodnat title z PageControlleru.java s touto hodnotou 
			$('#about').addClass('active'); // about odpovidajici id = 'about' z definice v navbar.jsp
			break;
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
		default:
			$('#home').addClass('active');
	}
		
	
});