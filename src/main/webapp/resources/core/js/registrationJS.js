$( document ).ready(function() {
	//alert("hello");
});
function departmentAddress(dname){
       $.ajax({
                type: 'get',
                url: '/getDepartmentAddress?dname='+dname,
                async : false,
                success: function(data){
                $("#dAddress").empty();
                     var addressList = "<option  disabled selected>Select Address:</option>";
                        $.each(data,function(index,value){
                            addressList = addressList + '<option value="' + value + '">' + value + '</option>';
                        });
                     $("#dAddress").append(addressList);
                 },
                 error : function(xhr, error, errorThrown) {
                 		 alert("An error occurred:\n" + xhr.responseJSON);
                 }
       });
 }