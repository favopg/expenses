export class App {
    /**
     * get送信でAPIからデータ取得
     * @param endpoint エンドポイント(/api/test)
     */
    async getApiRequest(endpoint) {
        await fetch(endpoint)
            .then(async (response) => {
            if (!response.ok) {
                console.log("システムエラーが発生しました。");
                throw new Error("Network response was not ok");
            }
            return await response.json();
        })
            .then(data => {
            console.log("Data received:", data);
            return data;
        });
    }
}
/**
const greeting: string = "helloWorld";
console.log(greeting);

fetch("/api/index")
    .then(response => {
        if (!response.ok) {
            throw new Error("Network response was not ok");
        }
        return response.json();
    })
    .then(data => {
        console.log("Data received:", data);
    })
 */ 
