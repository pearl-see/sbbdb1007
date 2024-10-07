/**
 * 
 */
function fetchMessages() {
	const messageList = document.getElementById('messageList_id');
	const loading = document.getElementById('loading_id');
	const error = document.getElementById('error_id');
	
	loading.style.display = 'block';
	error.style.display = 'none';
	messageList.innerHTML = '';
	
	fetch('/messages/api')
		.then(response => {
			// 응답 결과를 json으로 변환
			if(!response.ok) {
				throw new Error('Network response was not ok');
			}
			return response.json();
		})
		.then(messages => {
			// 변환된 결과를 li요소로 만들어 화면에 추가
			loading.style.display = 'none';
			messages.forEach(msg => {
				const li = document.createElement('li');
				// li.textContent = `<a href="/messages/${msg.id}">${msg.message} (${msg.id})</a>`;
				// li.innerText
				li.innerHTML = `<a href="/messages/${msg.id}">${msg.message} (${msg.id})</a>`;
				messageList.appendChild(li);
			})
		})
		.catch(error => {
			console.error('Fetch error:', err);
			loading.style.display = 'none';
			error.style.display = 'block';
		})
}

// 문서가 모두 로딩되면 fetchMessage() 함수를 실행
document.addEventListener('DOMContentLoaded', fetchMessages);