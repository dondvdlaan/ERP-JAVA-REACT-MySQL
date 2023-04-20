import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';

import { useApi } from '../../shared/API';
import { Copyright } from '../../shared/Copyright';
import Create from './Create';
import {  ListShipments } from './ListShipments';
import { Order } from '../../types/Order';
import { Shipment } from '../../types/Shipment';
import { Link } from 'react-router-dom';
import { Button } from '@mui/material';

/**
 * Component Shipping for overview of Create / Delete / List and Edit of products in Shipping
 */
function Shipping() {

  // *** Constants and variables ***
  const [shipments, setShipments] = useApi<Shipment[]>("shipping","api/shipments");

  // Wait till products arrive
  if(!shipments) return (<p>Loading Shipments...</p>)

  console.log("Shipments: ", shipments);

  // *** Event handlers ***
  const onDelete = (id: String | undefined) => console.log("Delete ",{id});

  const onCreate = () => console.log("Create ");


  return (
  <>
    {/* Header */}
    <Container maxWidth="lg" sx={{ display: 'flex', flexDirection: 'row' }}>
      <Box sx={{ my: 1, width:0.4 }} color="secondary.light"  >
        <Typography 
          variant="h5" 
          component="h3" 
          gutterBottom 
          color="primary.light"
          align = "left"
          >
          <Button type="button" >
              <Link to={`/home`}>HOME</Link>                
          </Button>
        </Typography>
      </Box>
      <Box sx={{ my: 1, width:0.6 }} color="secondary.light"  >
        <Typography 
        variant="h5" 
        component="h3" 
        gutterBottom 
        color="primary.light"
        align = "left"
        >
          Shipments testing
        </Typography>
      </Box>
    </Container>
    {/* End Header */}

    <main>
      <Container  >
        <Grid container spacing={1}>
        <Grid item xs={12} sm={6} md={6}>
            <Create />
          </Grid>
          <Grid item xs={12} sm={6} md={6}>
            <Create />
          </Grid>
          <Grid item xs={12} sm={12} md={12}>
            <ListShipments shipments={shipments} onDelete={onDelete} onCreate={onCreate}  />
          </Grid>
        </Grid>
      </Container>        
    </main>
    {/* Footer */}
    <Box sx={{ bgcolor: 'background.paper', p: 1, my:1 }} component="footer">
      <Copyright />
    </Box>
    {/* End footer */}
  </>  
  );
}

export default Shipping;
