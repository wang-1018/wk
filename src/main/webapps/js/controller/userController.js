 //控制层 
app.controller('userController' ,function($scope,$controller   ,userService){	
	
	$controller('baseController',{$scope:$scope});//继承

    // 读取三级分类
    $scope.$watch('entity.addr.cityid2', function(newValue,oldValue) {
        //根据选择的值，查询二级分类
        userService.findByParentId(newValue).success(function(response){
                $scope.itemCat3List=response;
            }
        );
    });

    //读取二级分类
    //$watch方法用于监控某个变量的值，当被监控的值发生变化，就自动执行相应的函数。
    $scope.$watch('entity.addr.cityid1', function(newValue,oldValue) {
        $scope.itemCat3List=[];
        //根据选择的值，查询二级分类
        userService.findByParentId(newValue).success(function(response){
                $scope.itemCat2List=response;
            }
        );
    });

    $scope.selectItemCat1List = function(){
        $scope.itemCat2List=[];
        $scope.itemCat3List=[];
        userService.findByParentId(1).success(function (response) {
            $scope.itemCat1List = response;
        })
    }

    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		userService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		userService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		userService.findOne(id).success(
			function(response){
				$scope.entity= response;
			}
		);				
	}

	$scope.entity = {addr:{}}
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象
		console.log($scope.entity.userid)
		if($scope.entity.userid!=null){//如果有ID
			serviceObject=userService.update( $scope.entity ); //修改  
		}else{
			serviceObject=userService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询
		        	$scope.reloadList();//重新加载
				}else{
					alert(response.message);
				}
			});
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		userService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	// $scope.search=function(page,rows){
	// 	userService.search(page,rows,$scope.searchEntity).success(
	// 		function(response){
	// 			$scope.list=response.rows;
	// 			$scope.paginationConf.totalItems=response.total;//更新总记录数
	// 		}
	// 	);
	// }
    
});	
