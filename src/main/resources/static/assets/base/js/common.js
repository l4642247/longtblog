//加载点击top8列表
function top8(){
    $.ajax({
        url:'/article/top8',
        method:'get',
        success:function(result){
            var html = '';
            $.each(result, function(i,val){
                html += '<li><a href="/info/'+val.id+'">'+val.title+'</a></li>';
            });
            $(".tuijian ul").append(html);
        }
    });
}

//加载类别列表
function catalogInit(){
    $.ajax({
        url:'/catalog/page',
        method:'get',
        success:function(result){
            var catalogs = result.content;
            var html = '';
            $.each(catalogs, function(i,val){
                html += '<li><a href="/index.html?catalogId='+val.id+'">'+val.name+'（'+val.count+'）</a></li>';
            });
            $(".fenlei ul").append(html);
        }
    });
}

//加载所有标签
function initAllTags(){
    $.ajax({
        url: '/tag/all',
        method: 'get',
        dataType:'json',
        success: function(result){
            var html = '';
            $.each(result.content, function(i, val){
                html += '<a href="/index.html?tag=' + val.id + '">'+val.name+'</a>';
            });
            $(".cloud ul").html(html);
        }
    });
}

