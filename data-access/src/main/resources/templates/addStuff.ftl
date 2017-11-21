<!DOCTYPE html>
<html>
    <head>
        <title>Cities</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css" />
        </head>
    <body>
        <h2>List of users</h2>
        
        <table>
            <tr>
                <th>Id</th>  
                <th>Name</th>  
            </tr>        

            <#list users as user>
                <tr>
                    <td>${user.id}</td> 
                    <td>${user.name}</td> 
                </tr>
            </#list>       
        </table>     
        
        <table>
            <tr>
                <th>Id</th>  
                <th>Book</th>
                <th>Author</th>  
            </tr>        
            <#list recipes as recipe>
                <tr>
                    <td>${recipe.id}</td> 
                    <td>${recipe.book}</td>
                    <td>${recipe.author}</td> 
                </tr>
            </#list>        
        </table>                 
    </body>
</html>