<!DOCTYPE html>
<html>
<head>
    <title>HawkerStalls</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h2>List of hawkerstalls</h2>

<table>
    <tr>
        <th>Id</th>
        <th>Thumbnail</th>
        <th>Name</th>
        <th>Rating</th>
        <th>Hawkercentrename</th>
        <th>Unitno</th>
        <th>Operationhours</th>
        <th>Communityrating</th>
        <th>Noofrating</th>
        <th>Originalcommunityrating</th>
        <th>Highlightitems</th>
        <th>Foodcategories</th>
    </tr>

    <#list hawkerstalls as hawkerstall>
    <tr>
        <td>${hawkerstall.id}</td>
        <td>${hawkerstall.thumbnail}</td>
        <td>${hawkerstall.name}</td>
        <td>${hawkerstall.rating}</td>
        <td>${hawkerstall.hawkercentrename}</td>
        <td>${hawkerstall.unitno}</td>
        <td>${hawkerstall.operationhours}</td>
        <td>${hawkerstall.communityrating}</td>
        <td>${hawkerstall.noofrating}</td>
        <td>${hawkerstall.originalcommunityrating}</td>
        <td>${hawkerstall.highlightitems}</td>
        <td>${hawkerstall.foodcategories}</td>

    </tr>
    </#list>
</table>
</body>
</html>