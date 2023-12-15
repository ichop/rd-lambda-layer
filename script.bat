@echo off

mkdir "D:\MyProjects\Java\RD_AWS_course\Final project\rd-lambda-layer\target\Java\lib"


echo Копирование файла rd-project-shared-code-1.0.0.jar в папку lib...
copy /Y "D:\MyProjects\Java\RD_AWS_course\Final project\rd-lambda-layer\target\rd-project-shared-code-1.0.0.jar" "D:\MyProjects\Java\RD_AWS_course\Final project\rd-lambda-layer\target\Java\lib"

echo Упаковка папки Java в ZIP архив...
cd /D "D:\MyProjects\Java\RD_AWS_course\Final project\rd-lambda-layer\target"
powershell Compress-Archive -Path .\Java -DestinationPath ".\layer.zip"

echo Завершено! Архив rd-project-shared-code.zip сохранен в корне проекта.
