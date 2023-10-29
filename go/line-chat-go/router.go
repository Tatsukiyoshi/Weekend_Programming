package chat

import (
	"net/http"

	"github.com/gin-gonic/gin"
	melody "gopkg.in/olahol/melody.v1"
)

func Run() {
	r := gin.Default()
	m := melody.New()

	r.Static("/static", "./view/static")
	r.LoadHTMLGlob("view/*.html")

	r.GET("/", func(c *gin.Context) {
		c.HTML(http.StatusOK, "index.html", gin.H{})
	})

	r.GET("/room/:name", func(c *gin.Context) {
		c.HTML(http.StatusOK, "room.html", gin.H{
			"Name": c.Param("name"),
		})
	})

	r.GET("/room/:name/ws", func(c *gin.Context) {
		m.HandleRequest(c.Writer, c.Request)
	})

	m.HandleMessage(func(s *melody.Session, msg []byte) {
		m.BroadcastFilter(msg, func(q *melody.Session) bool {
			return q.Request.URL.Path == s.Request.URL.Path
		})
	})

	r.Run(":8088")
}
