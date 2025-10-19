const express = require('express')
const app = express()
const port = 3000

app.get('/:latency?', (req, res) => {
  setTimeout(() => res.send('Hello!'), req.params.latency || 0);
})

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})
