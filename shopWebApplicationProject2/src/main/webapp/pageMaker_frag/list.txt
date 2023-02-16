<c:if test="${pageMaker.curPage > 1}">
    <a href="#" onclick="pageCall('1')">[처음]</a>
</c:if>
             
<!-- **이전페이지 블록으로 이동 : 현재 페이지 블럭이 1보다 크면 [이전]하이퍼링크를 화면에 출력 -->
<c:if test="${pageMaker.curPage > 1}">
    <a href="#" onclick="pageCall('${pageMaker.prevPage}')">[이전]</a>
</c:if>
<c:foreach var="num" begin="${pageMaker.blockBegin}" end="${pageMaker.blockEnd}">
    <!-- **현재페이지이면 하이퍼링크 제거 -->
    <c:choose>
        <c:when test="${num == pageMaker.curPage}">
            <span style="color: red">${num}</span> 
        </c:when>
        <c:otherwise>
            <a href="#" onclick="pageCall('${num}')">${num}</a> 
        </c:otherwise>
    </c:choose>
</c:foreach>
<c:if test="${pageMaker.curPage < pageMaker.totPage}">
    <a href="#" onclick="pageCall('${pageMaker.nextPage}')">[다음]</a>
</c:if>
 
<!-- **끝페이지로 이동 : 현재 페이지가 전체 페이지보다 작거나 같으면 [끝]하이퍼링크를 화면에 출력 -->
<c:if test="${pageMaker.curPage < pageMaker.totPage}">
    <a href="#" onclick="pageCall('${pageMaker.totPage}')">[끝]</a>
</c:if>