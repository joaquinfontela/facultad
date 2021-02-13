import React from 'react';
import { Title } from './Title/Title'
import { ButtonMenu } from './ButtonMenu/ButtonMenu'

export class Application extends React.Component {
    render(): JSX.Element {
        return (
            <div>
                <Title />
                <ButtonMenu />
            </div>
        );
    }
}