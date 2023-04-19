import Button from "@mui/material/Button";
import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import Grid from "@mui/material/Grid";
import Typography from "@mui/material/Typography";
import { Paper, styled } from "@mui/material";
import { Order } from "../../types/Order";

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: 'center',
  color: theme.palette.text.secondary,
}));


interface Props{
  orders: Order[],
  onDelete: (id: string | undefined) => void,
  onCreate: () => void
}
/**
 * Component to list all products from Inventory
 */
export const ListOrders = (props: Props) => {

    return (
      <>
      <Card
          sx={{ height: '100%', display: 'flex', flexDirection: 'column' }}
        >
          <CardContent sx={{ flexGrow: 1 }}>
            <Typography gutterBottom variant="h5" component="h4" align="center">
              List products
            </Typography>
            <Grid container spacing={2}>
            {props.orders.map(o =>

              <Grid key={o.orderID} item xs={12} md={6}>
                <Item>Id: {o.orderID} City: {o.shippingAddress.city} Status: {o.orderStatus}
                  <br /> 
                  <Button onClick={()=>props.onDelete(o.orderID)} size="small">Delete</Button>
                </Item>
              </Grid>
            
            )}  
            </Grid>
          </CardContent>
          <CardActions>
            <Button size="small">Ready</Button>
          </CardActions>
        </Card>            
        
    </>
        
    );
  }