/**
 * 
 */
// 리턴값 예) http://localhost:3000
function getBaseUrl() {
	let baseUrl = window.location.protocol + '//' + window.location.host;
	return baseUrl;
}