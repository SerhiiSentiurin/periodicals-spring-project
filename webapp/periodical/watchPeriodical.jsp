<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/language.tld" prefix="lang" %>
<html>
    <head>
        <title>Reader page</title>
        <meta charset="UTF-8">
    </head>
    <body>

        <form action = "/app/periodicals/periodical/search" method = "GET">
            <label for="topic"><lang:print message = "periodical.periodicalForSubscribing.jsp.label.find_periodical_by_topic"/>:</label>
            <select name="topic">
                <option value=""><no topic/></option>
                <option value="business"><lang:print message = "periodical.periodicalForSubscribing.jsp.option.business"/></option>
                <option value="sport" ><lang:print message = "periodical.periodicalForSubscribing.jsp.option.sport"/></option>
                <option value="technology"><lang:print message = "periodical.periodicalForSubscribing.jsp.option.technology"/></option>
            </select>

            <label for="name"><lang:print message = "periodical.periodicalForSubscribing.jsp.label.find_periodical_by_name"/>:</label>
            <input type="text" name="name"  />


            <input type = "hidden" name="page" value = "${page}"/>
            <button type ="submit"><lang:print message = "periodical.periodicalForSubscribing.jsp.button.search"/></button>
        </form>



        <form action = "/app/periodicals/periodical/sortByCost" method = "GET">
            <label for="name"><lang:print message = "periodical.watchPeriodical.jsp.label.sort_periodicals_by_cost"/>:</label><br>
            <input type = "hidden" name="topic" value = "${topic}"/>
            <input type = "hidden" name="name" value = "${name}"/>
            <input type = "hidden" name="page" value = "${page}"/>
            <input type = "submit" value ='<lang:print message = "periodical.watchPeriodical.jsp.button.sort"/>'>
            <input type = "submit" formaction="/app/periodicals/periodical/reversedSortByCost" value='<lang:print message = "periodical.watchPeriodical.jsp.button.reversed_sort"/>'>
        </form>

        <form action ="/app/periodicals/periodical/sortByName" method = "GET">
            <label for="name"><lang:print message = "periodical.watchPeriodical.jsp.label.sort_periodicals_by_name"/>:</label><br>
            <input type = "hidden" name="topic" value = "${topic}"/>
            <input type = "hidden" name="name" value = "${name}"/>
            <input type = "hidden" name="page" value = "${page}"/>
            <input type = "submit" value ='<lang:print message = "periodical.watchPeriodical.jsp.button.sort"/>'>
            <input type = "submit" formaction="/app/periodicals/periodical/reversedSortByName" value='<lang:print message = "periodical.watchPeriodical.jsp.button.reversed_sort"/>'>
        </form>

        <form accept-charset="UTF-8" method="GET" action="/app/periodicals/periodical/watch">
            <input type="hidden" name="page" value="1">
            <label for="name"><lang:print message = "periodical.watchPeriodical.jsp.label.click_to_see_all_periodicals"/>:</label>
            <input type = "submit"  value='<lang:print message = "periodical.watchPeriodical.jsp.button.all_periodicals"/>'>
            <br><br>
        </form>

        <button onclick="location.href='/app'"><lang:print message = "periodical.watchPeriodical.jsp.button.back_to_registration"/></button>

        <table id="listOfPeriodicals">
        <caption><lang:print message = "periodical.watchPeriodical.jsp.table.caption.periodicals"/></caption>
            <tr>
                <th><lang:print message = "periodical.periodicalForSubscribing.jsp.table.name"/></th>
                <th><lang:print message = "periodical.periodicalForSubscribing.jsp.table.topic"/></th>
                <th><lang:print message = "periodical.periodicalForSubscribing.jsp.table.cost"/></th>
                <th><lang:print message = "periodical.periodicalForSubscribing.jsp.table.description"/></th>
            </tr>
        <c:forEach items="${periodicals}" var="periodical">
            <tr>
                <td>${periodical.name}</td>
                <td>${periodical.topic}</td>
                <td>${periodical.cost}</td>
                <td>${periodical.description}</td>
            </tr>
        </c:forEach>
        </table>

        <table align = "center">
            <th><lang:print message = "periodical.watchPeriodical.jsp.pages"/></th>
            <td align = "center">
                <c:if test = "${countOfPages != 0}">
                    <c:forEach var = "i" begin = "1" end = "${countOfPages}">
                        <c:if test = "${i != page}">
                            <c:if test = "${path == '/app/periodicals/periodical/watch'}">
                                <a href="/app/periodicals/periodical/watch?page=${i}">  < ${i} >  </a>
                            </c:if>
                            <c:if test = "${path == '/app/periodicals/periodical/search'}">
                                <a href="/app/periodicals/periodical/search?topic=${topic}&name=${name}&page=${i}">  < ${i} >  </a>
                            </c:if>
                            <c:if test = "${path == '/app/periodicals/periodical/sortByCost'}">
                                <a href="/app/periodicals/periodical/sortByCost?topic=${topic}&name=${name}&page=${i}">  < ${i} >  </a>
                            </c:if>
                            <c:if test = "${path == '/app/periodicals/periodical/reversedSortByCost'}">
                                <a href="/app/periodicals/periodical/reversedSortByCost?topic=${topic}&name=${name}&page=${i}">  < ${i} >  </a>
                            </c:if>
                            <c:if test = "${path == '/app/periodicals/periodical/sortByName'}">
                                <a href="/app/periodicals/periodical/sortByName?topic=${topic}&name=${name}&page=${i}">  < ${i} >  </a>
                            </c:if>
                            <c:if test = "${path == '/app/periodicals/periodical/reversedSortByName'}">
                                <a href="/app/periodicals/periodical/reversedSortByName?topic=${topic}&name=${name}&page=${i}">  < ${i} >  </a>
                            </c:if>
                        </c:if>
                        <c:if test = "${i == page}">
                            <a>  < ${page} >  </a>
                        </c:if>
                    </c:forEach>
                </c:if>
            </td>
        </table>

        <style>
            caption {
                font-family: annabelle;
                font-weight: bold;
                font-size: 1.5em;
                padding: 10px;
                border: 1px solid #A9E2CC;
            }
            th {
                padding: 10px;
                border: 1px solid #A9E2CC;
            }
            td {
                font-size: 1.0em;
                padding: 5px 7px;
                border: 1px solid #A9E2CC;
            }
        </style>
    </body>
</html>