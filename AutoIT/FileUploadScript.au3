ControlFocus("Open", "", "Edit1")
Sleep(3000)

; Construct the path to the file using @ScriptDir
$filePath = @ScriptDir & "\RxLabel103383.pdf"

; Set the file path in the Open dialog
ControlSetText("Open", "", "Edit1", $filePath)
Sleep(3000)

ControlClick("Open", "", "Button1")
