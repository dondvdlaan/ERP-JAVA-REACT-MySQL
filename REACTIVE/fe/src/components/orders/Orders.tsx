import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';

import React from 'react';
import { useApi } from '../../shared/API';
import { Product } from '../../types/Product';
import { Copyright } from '../../shared/Copyright';
import Create from './Create';
import { ListOrders } from './ListOrders';
import { Order } from '../../types/Order';

/**
 * Component Inventory for overview of Create / Delete / List and Edit of products in Inventory
 */
function Orders() {

  // *** Constants and variables ***
  const [orders, setOrders] = useApi<Order[]>("orders","api/orders");

  // Wait till products arrive
  if(!orders) return (<p>Loading Orders...</p>)

  console.log("Orders: ", orders);

  // *** Event handlers ***
  const onDelete = (id: String | undefined) => console.log("Delete ",{id});

  const onCreate = () => console.log("Create ");


  return (
  <>
    {/* Header */}
    <Container maxWidth="sm">
      <Box sx={{ my: 1 }} color="secondary.light" >
        <Typography 
        variant="h5" 
        component="h3" 
        gutterBottom 
        color="primary.light"
        align = "center"
        >
          Orders testing
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
            <ListOrders orders={orders} onDelete={onDelete} onCreate={onCreate}  />
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

export default Orders;
