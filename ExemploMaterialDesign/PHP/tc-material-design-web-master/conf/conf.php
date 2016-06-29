<?php
	// PATH
        /*if( @fopen('CtrlCar.php', 'r') ){
            define('__PATH__', '../../');
        }
        else{
            define('__PATH__', './');
        }*/


        define('__PATH_FULL_URL__', 'http://192.168.1.20/android/tc-material-design-web-master/');
        //define('__PATH_FULL_URL__', 'http://YourComputerIp:8888/TCMaterialDesign/');

    // DATABASE
        $settingsDatabase = [
            'type'=>'mysql',
            'host'=>'localhost',
            'port'=>'3306',
            'name'=>'tc_cars',
            'username'=>'admin',
            'password'=>'admin',
            'charset'=>'utf8'
        ];
