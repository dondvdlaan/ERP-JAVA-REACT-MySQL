import Button from "@mui/material/Button";
import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import { LineItem, Order } from "../../types/Order";
import { apiSimplified } from "../../shared/API";
import { useNavigate } from "react-router-dom";
import { Address } from "../../types/Address";


export default function Create() {

  // ---- variables ----
  const navigate = useNavigate();
  const lineItems: LineItem[] = [ {prodID: 1, prodQuantity: 1},
                                  {prodID: 2, prodQuantity: 2}];

  const shippingAddress: Address = {name: "naampje",
                                    house: "huisje",
                                    street: "straatje",
                                    city: "stadje",
                                    zip: "zippie"                 
                                    };

  const newOrder: Order = {
    userID: "1",
    total: 100,
    lineItems,
    paymentMode: "Visa",
    shippingAddress,
    shippingDate: new Date(2023,11,20),
    orderStatus: "INITIATION_SUCCESS",
    responseMessage: "nothingToSeeHere"

    }
  // ---- Event Handlers ----
  const onSentOrder = () =>{

    apiSimplified("POST",
                  "orders",
                  "api/orders",
                  newOrder)
                  .then(res=> {
                    console.log("ResponsePOST: ", res)
                    
                    if(res.status == 200) window.location.reload();
                  })

  }

    return (
      <>
        <Card
          sx={{ height: '100%', display: 'flex', flexDirection: 'column' }}
        >
          <CardContent sx={{ flexGrow: 1 }}>
            <Typography gutterBottom variant="h5" component="h4" align="center">
              Create Order
            </Typography>
            <Typography>
                        New order is created hard coded in the script
            </Typography>
          </CardContent>
          <CardActions>
            <Button onClick={onSentOrder} size="small">Send Order</Button>
          </CardActions>
        </Card>
                
        
    </>
        
    );
  }