import { Button, Card, CardActions, CardContent, Grid, Typography } from "@mui/material"
import { Link } from "react-router-dom"



export const Dash = () => {

    // ---- Eventhandlers ----
   
    return(

        <Card
        sx={{ height: '100%', display: 'flex', flexDirection: 'column' }}
      >
        <CardContent sx={{ flexGrow: 1 }}>
          <Typography gutterBottom variant="h5" component="h4" align="center">
            Choose service
          </Typography>
          <Grid container spacing={2}>

            <Grid item xs={12} md={12}>

                <Typography gutterBottom variant="h5" component="h4" align="center">
                  <button type="button">
                      <Link to={`/inventory`}>Inventory</Link>                
                  </button>
                </Typography>
                <Typography gutterBottom variant="h5" component="h4" align="center">
                  <button type="button">
                      <Link to={`/orders`}>Orders</Link>                
                  </button>
                </Typography>
                <Typography gutterBottom variant="h5" component="h4" align="center">
                  <button type="button">
                      <Link to={`/shipping`}>Shipping</Link>                
                  </button>
                </Typography>
            </Grid>
          
          </Grid>
        </CardContent>
        <CardActions>
          <Button size="small">Ready</Button>
        </CardActions>
      </Card> 
    )
}