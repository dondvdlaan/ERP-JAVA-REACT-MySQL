import React from 'react';
import { render, screen } from '@testing-library/react';
import {Dash} from './components/Dash';

test('renders learn react link', () => {
  render(<Dash />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});
