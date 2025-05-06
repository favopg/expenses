export class App {

    /**
     * get送信でAPIからデータ取得
     * @param endpoint エンドポイント(/api/test)
     */
    public async getApiRequest(endpoint: string): Promise<any> {
        await fetch(endpoint)
            .then(async response => {
                if (!response.ok) {
                    console.log("システムエラーが発生しました。");
                    throw new Error("Network response was not ok");
                }
                return await response.json();
            })
            .then(data => {
                console.log("Data received:", data);
                return data;
            })
    }

    public getCategories() {
        window.localStorage.getItem("categories");
    }
}