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
        
        <h2>List of recipes with ingredients</h2>
        
        <table>
            <tr>
                <th>Id</th>  
                <th>Book</th>
                <th>Author</th>  
            </tr>        
            <#list recipes as recipe>
                <tr>
                    <td><b>${recipe.id}</b></td> 
                    <td><b>${recipe.book}</b></td>
                    <td><b>${recipe.author}</b></td> 
                </tr>
                <#list recipe.ingredients as ingredient>
                <tr>
                    <td>${ingredient.amount}</td> 
                    <td>${ingredient.unit}</td>
                    <td>${ingredient.item}</td> 
                </tr>
                </#list>
            </#list>        
        </table>        
        
        <h2>List of tracking entries</h2>
        
         <table>
            <tr>
                <th>value</th>  
                <th>name</th>
            </tr>        
            <#list ratings as rating>
                <tr>
                    <td>${rating.value}</td>
                    <td>${rating.trackingEntry.name}</td>
                </tr>
            </#list>        
        </table>      
        
        <h2>List of ingredients</h2>
        
       <table>
            <tr>
                <th>amount</th>  
                <th>unit</th>
                <th>item</th>  
            </tr>        
            <#list ingredients as ingredient>
                <tr>
                    <td>${ingredient.amount}</td> 
                    <td>${ingredient.unit}</td>
                    <td>${ingredient.item}</td> 
                </tr>
            </#list>        
        </table>           
    </body>
</html>