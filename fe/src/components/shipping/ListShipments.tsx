import Button from "@mui/material/Button";
import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import Grid from "@mui/material/Grid";
import Typography from "@mui/material/Typography";
import { Paper, styled } from "@mui/material";
import { Order } from "../../types/Order";
import { Shipment } from "../../types/Shipment";

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: 'center',
  color: theme.palette.text.secondary,
}));


interface Props{
  shipments: Shipment[],
  onDelete: (id: string | undefined) => void,
  onCreate: () => void
}
/**
 * Component to list all products from Shipping
 */
export const ListShipments = (props: Props) => {

    return (
      <>
      <Card
          sx={{ height: '100%', display: 'flex', flexDirection: 'column' }}
        >
          <CardContent sx={{ flexGrow: 1 }}>
            <Typography gutterBottom variant="h5" component="h4" align="center">
              List shipments
            </Typography>
            <Grid container spacing={2}>
            {props.shipments.map(s =>

              <Grid key={s.shipmentID} item xs={12} md={6}>
                <Item>Id: {s.shipmentID} City: {s.address.city} Date: {new Date(s.shippingDate).toLocaleDateString()}
                  <br /> 
                  <Button onClick={()=>props.onDelete(s.shipmentID)} size="small">Delete</Button>
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