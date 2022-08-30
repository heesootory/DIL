const registBtn = document.querySelector("#regist")
const inputTag = document.querySelector("#todo-value")
const ulTag = document.querySelector("#todo-list")
const btnOk = document.querySelector("#btn-ok")
const btnNo = document.querySelector("#btn-no")
const btnAll = document.querySelector("#btn-all")


let todoList;

function registTodo(){
    const content = inputTag.value;
    
    if(!content.trim()){        // 빈 문자열일 때, false 이므로
        alert("할일을 입력하세요!!")
    }else{

        ulTag.appendChild(liTag)    //목록에 추가
        inputTag.value = ""     // 입력 초기화
        inputTag.focus()        // 키가 다시 inputTag로 돌아오기 하기.
    }
}

const createTodoItem = (todoItem) => {
    // li태그 생성 후 값 채우기
    const liTag = document.createElement("li")
    let spanTag = document.createElement("span")

    spanTag.innerText = todoItem.todo;

    spanTag.addEventListener("click", () => {
        updateTodo()
    })

    liTag.appendChild(spanTag)

    // 삭제 이벤트 달기
    const delBtn = document.createElement("button")
    delBtn.innerText = "X"
    delBtn.addEventListener("click", () =>{
        removeTodo();
    })

    liTag.appendChild(delBtn)

    ulTag.appendChild(liTag)
}

const updateTodo = () =>{
    event.target.classList.toggle("done")
}

const removeTod = () =>{
    event.target.parentElement.remove()
}


//등록 버튼을 눌렸다면 이벤트를 걸자

registBtn.addEventListener("click", registTodo)
