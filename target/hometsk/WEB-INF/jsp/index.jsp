<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
       <script type="text/javascript">
            $(document).ready(function() {
                $('#callPOST').click(function ()
                {
                    $.ajax({
                        type: "post",
                        url: "/hometsk/cool",
                        success: function(msg){
                                $('#output').text(msg);
                        }
                    });
                });

                $('#callPUT').click(function ()
                   {
                       $.ajax({
                              type: "put",
                              url: "/hometsk/cool",
                               success: function(msg){
                                                $('#output').text(msg);
                                        }
                         });
                });
                $('#callGET').click(function ()
                {
                    $.ajax({
                          type: "get",
                          url: "/hometsk/cool?ajax=true",
                          success: function(msg){
                               $('#output').text(msg);
                                        }
                          });
             });
            $('#callDELETE').click(function ()
                {
                      $.ajax({
                        type: "delete",
                       url: "/hometsk/cool",
                        success: function(msg){
                        $('#output').text(msg);
                                                    }
                                      });
                         });

            });

        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
</head>
<style type="text/css">
.classname {
 text-align:center;
}
</style>
<body>
    <input type="button" value="POST" name="POST" id="callPOST"/>
    <input type="button" value="PUT" name="PUT" id="callPUT"/>
    <input type="button" value="GET" name="GET" id="callGET"/>
    <input type="button" value="DELETE" name="DELETE" id="callDELETE"/>
    <div id="output"></div>
<h2>wtf</h2>
</body>
</html>

