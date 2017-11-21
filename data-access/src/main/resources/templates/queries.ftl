<!DOCTYPE html>
<html>
    <head>
        <title>Cities</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css" />
        </head>
    <body>
    
       <h2>onions by count</h2>
        
		<h3>${ingredientscount}</h3> 
        
        <h2>Unique onions</h2>
        
		<table>
            <tr>
                <th>amount</th>  
                <th>unit</th>
                <th>item</th>  
            </tr>        
            <#list ingredientsunit as ingredient>
                <tr>
                    <td>${ingredient.amount}</td> 
                    <td>${ingredient.unit}</td>
                    <td>${ingredient.item}</td> 
                </tr>
            </#list>        
        </table>    
        
        <h2>top three onions</h2>
        
		<table>
            <tr>
                <th>amount</th>  
                <th>unit</th>
                <th>item</th>  
            </tr>        
            <#list ingredientsthree as ingredient>
                <tr>
                    <td>${ingredient.amount}</td> 
                    <td>${ingredient.unit}</td>
                    <td>${ingredient.item}</td> 
                </tr>
            </#list>        
        </table>    
        
        <h2>All ingredients to compare</h2>
        
        <table>
            <tr>
                <th>amount</th>  
                <th>unit</th>
                <th>item</th>  
            </tr>        
            <#list ingredientsall as ingredient>
                <tr>
                    <td>${ingredient.amount}</td> 
                    <td>${ingredient.unit}</td>
                    <td>${ingredient.item}</td> 
                </tr>
            </#list>        
        </table>         
         
    </body>
</html>