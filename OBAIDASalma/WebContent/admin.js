window.onload=function()
{
    document.getElementById("afflangue").addEventListener("click",AffcherLangue);
document.getElementById("profile").addEventListener("click",AffcherProfile);
document.getElementById("info").addEventListener("click",AffcherInfo);
document.getElementById("exp").addEventListener("click",AffcherExport);
}

function AffcherLangue()
{
	if(document.getElementById("langue").style.display=="none")
    {
	 document.getElementById("langue").style.display="block";
  }else{
	document.getElementById("langue").style.display="none";
}
      
}
function AffcherProfile()
{
	if(document.getElementById("affiprofile").style.display=="none")
    {
	 document.getElementById("affiprofile").style.display="block";
  }else{
	document.getElementById("affiprofile").style.display="none";
}
      
}
function AffcherInfo()
{
	if(document.getElementById("affinfo").style.display=="none")
    {
	 document.getElementById("affinfo").style.display="block";
  }else{
	document.getElementById("affinfo").style.display="none";
}
      
}
function AffcherExport()
{
	if(document.getElementById("affiexp").style.display=="none")
    {
	 document.getElementById("affiexp").style.display="block";
  }else{
	document.getElementById("affiexp").style.display="none";
}
      
}