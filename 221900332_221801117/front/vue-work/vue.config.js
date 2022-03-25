module.exports = {
    outputDir: 'dist',   //build输出目录
    assetsDir: 'assets', //静态资源目录（js, css, img）
    lintOnSave: false, //是否开启eslint
    configureWebpack: {
        // devtool
        devtool: 'cheap-module-eval-source-map'
    },
    devServer: {
        open: true, //是否自动弹出浏览器页面
        host: "localhost",
        port: '8080',
        https: false,   //是否使用https协议
        hotOnly: false, //是否开启热更新
        proxy: { //配置多个跨域
            "/api1": {
                target: "http://1.116.239.153:8081/DongAo/",
                changeOrigin: true,
                ws: true,//websocket支持
                secure: false,
                pathRewrite: {
                    "^/api1": ""
                }
            },
        }
    }
}
